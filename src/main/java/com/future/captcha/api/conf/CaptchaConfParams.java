package com.future.captcha.api.conf;

/**
 * @author liuyunfei
 */
@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class CaptchaConfParams implements CaptchaConf {

    protected Boolean border = true;

    protected String borderColor = "green";

    protected Integer borderThickness = 1;

    protected String producerImpl = "com.google.code.kaptcha.impl.DefaultKaptcha";

    protected String textProducerImpl = "com.google.code.kaptcha.text.impl.DefaultTextCreator";

    protected String textProducerCharString = "one pro";

    protected Integer textProducerCharLength = 5;

    protected String textProducerFontNames = "Arial,Courier";

    protected Integer textProducerFontSize = 40;

    protected String textProducerFontColor = "white";

    protected Integer textProducerCharSpace = 2;

    protected String noiseImpl = "com.google.code.kaptcha.impl.DefaultNoise";

    protected String noiseColor = "cyan";

    protected String obscurificatorImpl = "com.google.code.kaptcha.impl.WaterRipple";

    protected String wordImpl = "com.google.code.kaptcha.text.impl.DefaultWordRenderer";

    protected String backgroundImpl = "com.google.code.kaptcha.impl.DefaultBackground";

    protected String backgroundClearFrom = "red";

    protected String backgroundClearTo = "yellow";

    protected Integer imageWidth = 200;

    protected Integer imageHeight = 50;

    public CaptchaConfParams() {
    }

    @Override
    public Boolean getBorder() {
        return border;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public Integer getBorderThickness() {
        return borderThickness;
    }

    @Override
    public String getProducerImpl() {
        return producerImpl;
    }

    @Override
    public String getTextProducerImpl() {
        return textProducerImpl;
    }

    @Override
    public String getTextProducerCharString() {
        return textProducerCharString;
    }

    @Override
    public Integer getTextProducerCharLength() {
        return textProducerCharLength;
    }

    @Override
    public String getTextProducerFontNames() {
        return textProducerFontNames;
    }

    @Override
    public Integer getTextProducerFontSize() {
        return textProducerFontSize;
    }

    @Override
    public String getTextProducerFontColor() {
        return textProducerFontColor;
    }

    @Override
    public Integer getTextProducerCharSpace() {
        return textProducerCharSpace;
    }

    @Override
    public String getNoiseImpl() {
        return noiseImpl;
    }

    @Override
    public String getNoiseColor() {
        return noiseColor;
    }

    @Override
    public String getObscurificatorImpl() {
        return obscurificatorImpl;
    }

    @Override
    public String getWordImpl() {
        return wordImpl;
    }

    @Override
    public String getBackgroundImpl() {
        return backgroundImpl;
    }

    @Override
    public String getBackgroundClearFrom() {
        return backgroundClearFrom;
    }

    @Override
    public String getBackgroundClearTo() {
        return backgroundClearTo;
    }

    @Override
    public Integer getImageWidth() {
        return imageWidth;
    }

    @Override
    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setBorder(Boolean border) {
        this.border = border;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void setBorderThickness(Integer borderThickness) {
        this.borderThickness = borderThickness;
    }

    public void setProducerImpl(String producerImpl) {
        this.producerImpl = producerImpl;
    }

    public void setTextProducerImpl(String textProducerImpl) {
        this.textProducerImpl = textProducerImpl;
    }

    public void setTextProducerCharString(String textProducerCharString) {
        this.textProducerCharString = textProducerCharString;
    }

    public void setTextProducerCharLength(Integer textProducerCharLength) {
        this.textProducerCharLength = textProducerCharLength;
    }

    public void setTextProducerFontNames(String textProducerFontNames) {
        this.textProducerFontNames = textProducerFontNames;
    }

    public void setTextProducerFontSize(Integer textProducerFontSize) {
        this.textProducerFontSize = textProducerFontSize;
    }

    public void setTextProducerFontColor(String textProducerFontColor) {
        this.textProducerFontColor = textProducerFontColor;
    }

    public void setTextProducerCharSpace(Integer textProducerCharSpace) {
        this.textProducerCharSpace = textProducerCharSpace;
    }

    public void setNoiseImpl(String noiseImpl) {
        this.noiseImpl = noiseImpl;
    }

    public void setNoiseColor(String noiseColor) {
        this.noiseColor = noiseColor;
    }

    public void setObscurificatorImpl(String obscurificatorImpl) {
        this.obscurificatorImpl = obscurificatorImpl;
    }

    public void setWordImpl(String wordImpl) {
        this.wordImpl = wordImpl;
    }

    public void setBackgroundImpl(String backgroundImpl) {
        this.backgroundImpl = backgroundImpl;
    }

    public void setBackgroundClearFrom(String backgroundClearFrom) {
        this.backgroundClearFrom = backgroundClearFrom;
    }

    public void setBackgroundClearTo(String backgroundClearTo) {
        this.backgroundClearTo = backgroundClearTo;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    @Override
    public String toString() {
        return "CaptchaConfParams{" +
                "border=" + border +
                ", borderColor='" + borderColor + '\'' +
                ", borderThickness=" + borderThickness +
                ", producerImpl='" + producerImpl + '\'' +
                ", textProducerImpl='" + textProducerImpl + '\'' +
                ", textProducerCharString='" + textProducerCharString + '\'' +
                ", textProducerCharLength=" + textProducerCharLength +
                ", textProducerFontNames='" + textProducerFontNames + '\'' +
                ", textProducerFontSize=" + textProducerFontSize +
                ", textProducerFontColor='" + textProducerFontColor + '\'' +
                ", textProducerCharSpace=" + textProducerCharSpace +
                ", noiseImpl='" + noiseImpl + '\'' +
                ", noiseColor='" + noiseColor + '\'' +
                ", obscurificatorImpl='" + obscurificatorImpl + '\'' +
                ", wordImpl='" + wordImpl + '\'' +
                ", backgroundImpl='" + backgroundImpl + '\'' +
                ", backgroundClearFrom='" + backgroundClearFrom + '\'' +
                ", backgroundClearTo='" + backgroundClearTo + '\'' +
                ", imageWidth=" + imageWidth +
                ", imageHeight=" + imageHeight +
                '}';
    }

}
