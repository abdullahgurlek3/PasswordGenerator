package controllers;

import dao.Password;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("Password", new Password());
        return "form";
    }

    /**
     * Form tarafından gönderilen veriler bu fonksiyon tarafından alınır,Form
     * girişlerinde hata varsa tekrar dönüş yapılır. Hata yoksa webservis url
     * adresine parametreler gön- derilerek gerekli bilgiler alınır. Alınan
     * bilgiler json tipinde olduğundan parse edilerek jsp dosyasına gönderilir.
     *
     * @param password Gelen şifre objesi
     * @param result validator tarafından düzenlenir
     *
     */
    @RequestMapping(method = RequestMethod.POST)
    public String indexOk(@Valid @ModelAttribute("Password") Password password,
            BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "form";
        }
        String uri = "http://localhost:8084/beta3/?length={length}"
                + "&includeLetters={includeLetters}"
                + "&includeMixedCase={includeMixedCase}"
                + "&includeNumber={includeNumber}"
                + "&includePunctuation={includePunctuation}"
                + "&noSimilarCharacters={noSimilarCharacters}"
                + "&quantity={quantity}";

        Map params = new HashMap();
        params.put("length", password.getLength());
        params.put("includeLetters", password.getIncludeLetters());
        params.put("includeMixedCase", password.getIncludeMixedCase());
        params.put("includeNumber", password.getIncludeNumber());
        params.put("includePunctuation", password.getIncludePunctuation());
        params.put("noSimilarCharacters", password.getNoSimilarCharacters());
        params.put("quantity", password.getQuantity());

        RestTemplate restTemplate = new RestTemplate();

        String getJson = restTemplate.getForObject(uri, String.class, params);

        String newPasswordsString = "";

        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(getJson);

            JSONArray newPasswords = (JSONArray) jsonObject.get("newPasswords");

            for (int i = 0; i < newPasswords.size(); i++) {
                JSONObject jsonObjectField = (JSONObject) newPasswords.get(i);
                String passwordText = HtmlUtils.htmlEscape((String) jsonObjectField.get("password"));
                newPasswordsString += "<div>" + passwordText + "</div>";
            }

        } catch (ParseException ex) {
            ex.printStackTrace();;
        }

        model.addAttribute("newPasswordsString", newPasswordsString);

        return "result";
    }

    @ResponseBody
    @RequestMapping("/logs")
    public String logs() throws FileNotFoundException, IOException {
        File file = new File("/tmp/log4j-application.log");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String read;
        StringBuilder returnText = new StringBuilder();
        while ((read = br.readLine()) != null) {
            returnText.append(read);
        }
        return returnText.toString().replace("DEBUG", "DEBUG<br/>");
    }

}
