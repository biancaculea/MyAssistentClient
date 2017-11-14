package my.client.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.*;




public class Person implements Serializable {

    private int id;

    private String firstname;
    private String lastname;

    private String email;
    private String phone;
    private List<Tichet> tichets =new ArrayList<>();


    public List<Tichet> getTichets() {
        return tichets;
    }

    public void setTichets(List<Tichet> tichets) {
        this.tichets = tichets;
    }

    public Person(){}

    public Person(String firstname, String lastname, String email, String phone, List<Tichet> tichets) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.tichets = tichets;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public String getFirstname(){
        return this.firstname;
    }

    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public String getLastname(){
        return this.lastname;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getPhone(){
        return this.phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", tichets=" + tichets +
                '}';
    }


//    @Override
//   public String toString(){
//
//       JSONObject JsonInfo = new JSONObject();
//
//        JsonInfo.put("FirstName",this.firstname);
//        JsonInfo.put("LastName ",this.lastname);
//
//        JSONArray  JsonArray = new JSONArray();
//        JSONObject subJson = new JSONObject();
//        subJson.put("Email ",this.email);
//        JsonArray.put(subJson);
//        subJson.put("Phone ",this.phone);
//        JsonArray.put(subJson);
//        JsonInfo.put("Detalii: ", JsonArray);
//
//        return JsonInfo.toString();   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!getFirstname().equals(person.getFirstname())) return false;
        if (!getLastname().equals(person.getLastname())) return false;
        return getEmail().equals(person.getEmail());
    }

    @Override
    public int hashCode() {
        int result = getFirstname().hashCode();
        result = 31 * result + getLastname().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }
}
