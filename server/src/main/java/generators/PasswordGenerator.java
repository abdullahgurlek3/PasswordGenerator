/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import entities.PasswordEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 * Random şifre üretme işlemini yürüten sınıftır.
 */

@Component
public class PasswordGenerator {

    Character[] lovercases;
    Character[] uppercases;
    Character[] punctuations = {'[', ']', '[', '(', ')', '{', '}', ',', '.', ';', '!', '?', '<', '>', '%', ']'};

    Integer[] numbers;

    public PasswordGenerator() {
        List<Character> lovercaseslist = new ArrayList<>();
        List<Character> uppercaseslist = new ArrayList<>();
        List<Integer> numberslist = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            lovercaseslist.add(c);
        }
        lovercases = lovercaseslist.toArray(new Character[0]);

        for (char c = 'A'; c <= 'Z'; c++) {
            uppercaseslist.add(c);
        }

        uppercases = uppercaseslist.toArray(new Character[0]);

        for (int i = 0; i < 10; i++) {
            numberslist.add(i);
        }
        numbers = numberslist.toArray(new Integer[0]);
    }

    PasswordEntity passwordEntity;

    public String generatePassword() {
        List allCharacters = new ArrayList<>();
        if (passwordEntity.getIncludeLetters()) {
            allCharacters.addAll(Arrays.asList(lovercases));
        }
        if (passwordEntity.getIncludeMixedCase()) {
            allCharacters.addAll(Arrays.asList(uppercases));
        }
        if (passwordEntity.getIncludeNumber()) {
            allCharacters.addAll(Arrays.asList(numbers));
        }
        if (passwordEntity.getIncludePunctuation()) {
            allCharacters.addAll(Arrays.asList(punctuations));
        }

        String returnString = "";
        Random random = new Random();
        for (int i = 0; i < passwordEntity.getLength(); i++) {
            int index = random.nextInt(allCharacters.size());

            if (passwordEntity.getNoSimilarCharacters()) {
                if (returnString.contains(allCharacters.get(index).toString())) {
                    i--;
                    continue;
                }
            }
            returnString += allCharacters.get(index);
        }

        return returnString;
    }

    public PasswordEntity getPasswordEntity() {
        return passwordEntity;
    }

    public void setPasswordEntity(PasswordEntity passwordEntity) {
        this.passwordEntity = passwordEntity;
    }

    public Character[] getLovercases() {
        return lovercases;
    }

    public Character[] getUppercases() {
        return uppercases;
    }

    public Character[] getPunctuations() {
        return punctuations;
    }

    public Integer[] getNumbers() {
        return numbers;
    }

}
