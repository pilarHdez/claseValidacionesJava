import java.util.Hashtable;

public class Validaciones{
    private int minLength;
    private int maxLength;
    String pattern;

    private String errorLength; 
    private String errorPattern;
    private String error;
    
    Hashtable<String, String> commonPatterns = new Hashtable<String,String>();
    
    private String validate; // Cadena a validar
    
    public Validaciones(){
        this.errorLength = "N\u00famero de caracteres inv\u00e1lido.";
        this.errorPattern = "Campo inv\u00e1lido.";
        
        commonPatterns.put("Int+", "^[1-9][0-9]+$");
        commonPatterns.put("Int+", "^[0-9]+$");
        commonPatterns.put("NameES", "^[a-zA-Z\u00e1\u00e9\u00ed\u00f3\u00fa\u00c1\u00c9\u00cd\u00d3\u00da\u00f1\u00d1]+$");
        commonPatterns.put("NameEN", "^[a-zA-Z]+$");
        commonPatterns.put("Email", "^[a-zA-Z0-9+&*-]+(?:.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+.)+[a-zA-Z]{2,7}$");
    }
    
    public Validaciones(String validate){
        this();
        this.validate = validate.trim();
    }
    
    public Validaciones(String validate, int minLength,int maxLength){
        this(validate); 
        this.minLength = minLength; 
        this.maxLength = maxLength;
    }
    
    public Validaciones(String pattern,String validate,int minLength,int maxLength){
        this();
        this.pattern = pattern;
        this.minLength = minLength; 
        this.maxLength = maxLength;
        this.validate = validate.trim();
    }
    
    public Validaciones(int minLength,int maxLength,String commonPattern, String validate){
        this();
        this.pattern = commonPatterns.get(commonPattern);
        this.minLength = minLength; 
        this.maxLength = maxLength;
        this.validate = validate.trim();
    }
    
     public Validaciones(String pattern,String validate,int minLength,int maxLength,String errorLength,String errorPattern){
        this(pattern, validate, minLength, maxLength);
        this.errorLength = errorLength;
        this.errorPattern = errorPattern;
     }
     
     public boolean validateLength(){
         this.error = "";
         
         if(this.minLength < 0 || this.maxLength <0 || this.minLength > this.maxLength){
             this.error = "Error: Longitudes inv\u00e1lidas.";
             return false;
         }
         
         if(this.minLength < this.validate.length() && this.validate.length() < this.maxLength){
             return true;
         } 
         
         this.error = this.errorLength; 
         return false;
     }
     
     public boolean validatePattern(){
         this.error = "";
         
         if(this.validate.matches(this.pattern)){
            return true; 
         }
         
         this.error = this.errorPattern;
         return false;
     }
     
     public boolean validateAll(){
         if(this.validateLength()){
            return this.validatePattern(); 
         } else {
             return false;
         }
     }
     
     public String getPattern(){
        return this.pattern;
     }
     
     public void setPattern(String pattern){
        this.pattern = pattern;
     }
     
     public void setCommonPattern(String commonPattern){
         this.pattern = commonPatterns.get(commonPattern);
     }
     
     public int getMinLength(){
        return this.minLength;
     }
     
     public void setMinLength(int minLength){
        this.minLength = minLength; 
     }
     
     public int getMaxLength(){
        return this.maxLength;
     }
     
     public void setMaxLength(int maxLength){
        this.maxLength = maxLength; 
     }
     
     public String getErrorLength(){
        return this.errorLength;
     }
     
     public void setErrorLength(String errorLength){
        this.errorLength = errorLength; 
     }
     
     public String getErrorPattern(){
        return this.errorPattern;
     }
     
     public void setErrorPattern(String errorPattern){
        this.errorPattern = errorPattern;
     }
     
     public String getError(){
         return this.error = error;
     }
     
     public void setError(String error){
         this.error = error;
     }
     
     public String getValidate(){
         return this.validate;
     }
     
     public void setValidate(String validate){
         this.validate = validate;
     }
     
     
     public static void main(String[] args){
         Validaciones example = new Validaciones(1,10,"NameES", "pilar123"); // validar que la cadena pilar sea un nombre
         boolean valida = example.validateAll();
         
         System.out.println("La cadnea es valida?: "+valida+ " error:"+example.getError());
     }
    
}