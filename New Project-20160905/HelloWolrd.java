import java.util.Hashtable;

public class HelloWorld{

    private int maxLength;
    private int minLength;
    String pattern;

    private String errorLength; 
    private String errorPattern;
    
    Hashtable<String, String> commonPatterns = new Hashtable<String,String>();
    
    
    public HelloWorld(){
        this.errorLength = "Número de caracteres inválido."
        this.errorPattern = "Campo inválido";
        
        commonPatterns.put("Int+", "^[1-9][0-9]+$");
        commonPatterns.put("Int+", "^[0-9]+$");
        commonPatterns.put("NameES", "^[a-zA-ZáéíóúÁÉÍÓÚÑñäëïöüÄËÏÖÜ]+$");
        commonPatterns.put("NameEN", "^[a-zA-Z]+$");
        commonPatterns.put("Email", "^[a-zA-Z0-9+&*-]+(?:.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+.)+[a-zA-Z]{2,7}$");
    }
    
    

     public static void main(String []args){
        System.out.println("Hello World");
     }
}
