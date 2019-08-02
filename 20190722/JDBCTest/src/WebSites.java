public class WebSites {
  private int id;
  private String name;
  private String url;
  private int alexa;
  private String country;

  public void setName(String name){
    this.name=name;
  }
  public void setUrl(String url){
    this.url=url;
  }
  public void setAlexa(int alexa){
    this.alexa = alexa;
  }
  public void setCountry(String country){
    this.country = country;
  }
  public String toString(){
    return getClass().toString()+"[ name: "+name+", url: "+url+", alexa: "+alexa+", country: "+country+" ]";
  }
}
