package member;

public class MemberVO {
  private String id;
  private String pw;
  private String name;
  private String gender;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public MemberVO(String id, String pw, String name, String gender) {
    this.id = id;
    this.pw = pw;
    this.name = name;
    this.gender = gender;
  }
}
