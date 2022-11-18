# captcha

### application.yml
```
captcha:
  border: true
  borderColor: green
  borderThickness: 1
  producerImpl: com.google.code.kaptcha.impl.DefaultKaptcha
  textProducerImpl: com.google.code.kaptcha.text.impl.DefaultTextCreator
  textProducerCharString: one pro
  textProducerCharLength: 5
  textProducerFontNames: Arial,Courier
  textProducerFontSize: 40
  textProducerFontColor: white
  textProducerCharSpace: 2
  noiseImpl: com.google.code.kaptcha.impl.DefaultNoise
  noiseColor: cyan
  obscurificatorImpl: com.google.code.kaptcha.impl.WaterRipple
  wordImpl: com.google.code.kaptcha.text.impl.DefaultWordRenderer
  backgroundImpl: com.google.code.kaptcha.impl.DefaultBackground
  backgroundClearFrom: red
  backgroundClearTo: yellow
  imageWidth: 200
  imageHeight: 50
```




### project
#### config class
```
@Component
@ConfigurationProperties(prefix = "captcha")
public class ProCaptchaConfig extends CaptchaConfParams {
}
```

#### use
```
    @Autowired
    private CaptchaProcessor captchaProcessor;
    
    
    captchaProcessor.generateVerifyCode();
    captchaProcessor.verify();
```