package dao;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 * Client katmanı Form Validation için model dosyasıdır.
 */
public class Password {

    @Min(8)
    @Max(24)
    private int length = 12;

    @AssertTrue
    boolean includeLetters = true;

    boolean includeMixedCase = true;
    boolean includeNumber = true;
    boolean includePunctuation = true;
    boolean noSimilarCharacters = true;

    @Min(1)
    int quantity = 1;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
