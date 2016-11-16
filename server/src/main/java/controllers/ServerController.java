/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.MySessionFactory;
import entities.PasswordEntity;
import generators.PasswordGenerator;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Controller
@RequestMapping("/")
public class ServerController {

    @Autowired
    PasswordGenerator passwordGenerator;

    @Autowired
    MySessionFactory MySessionFactoryInstance;

    /**
     *
     * Client tarafından gönderilen verileri işleyerek veritabanına kaydını
     * yapan fonksiyondur
     *
     * @param passwordEntity Veritabanına kayıt için kullandığımız entity nesnesi
     * @param request İstek nesnesi
     * @return Json türünde çıktı üretilir
     */
    @ResponseBody
    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String serverIndex(@ModelAttribute("PasswordEntity") PasswordEntity passwordEntity,
            HttpServletRequest request) {
        JSONObject json = new JSONObject();

        JSONArray newPasswordArray = new JSONArray();

        passwordEntity.setAddr(request.getRemoteAddr());
        passwordGenerator.setPasswordEntity(passwordEntity);

        for (int i = 0; i < passwordEntity.getQuantity(); i++) {

            JSONObject subJson = new JSONObject();
            passwordEntity.setPassword(passwordGenerator.generatePassword());

            Session session = MySessionFactoryInstance.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(passwordEntity);
            session.getTransaction().commit();
            session.close();
            subJson.put("password", passwordEntity.getPassword());

            newPasswordArray.add(subJson);
        }

        json.put("newPasswords", newPasswordArray);

        return json.toString();
    }
}
