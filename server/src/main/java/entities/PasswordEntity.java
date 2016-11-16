/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 * 
 * Veritabanına Kayıt ekleme silme gibi işlemler bu sınıf üzerinden yapılır
 */
@Entity
public class PasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    private int length = 12;
    boolean includeLetters = true;
    boolean includeMixedCase = true;
    boolean includeNumber = true;
    boolean includePunctuation = true;
    boolean noSimilarCharacters = true;

    String password;

    String addr;

    private int quantity;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean getIncludeLetters() {
        return includeLetters;
    }

    public void setIncludeLetters(boolean includeLetters) {
        this.includeLetters = includeLetters;
    }

    public boolean getIncludeMixedCase() {
        return includeMixedCase;
    }

    public void setIncludeMixedCase(boolean includeMixedCase) {
        this.includeMixedCase = includeMixedCase;
    }

    public boolean getIncludeNumber() {
        return includeNumber;
    }

    public void setIncludeNumber(boolean includeNumber) {
        this.includeNumber = includeNumber;
    }

    public boolean getIncludePunctuation() {
        return includePunctuation;
    }

    public void setIncludePunctuation(boolean includePunctuation) {
        this.includePunctuation = includePunctuation;
    }

    public boolean getNoSimilarCharacters() {
        return noSimilarCharacters;
    }

    public void setNoSimilarCharacters(boolean noSimilarCharacters) {
        this.noSimilarCharacters = noSimilarCharacters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

}
