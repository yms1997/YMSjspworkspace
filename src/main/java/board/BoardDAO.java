package board;

import java.time.LocalDate;
import java.util.ArrayList;

public class BoardDAO {
  private ArrayList<Board> list;
  private int cnt;

  public BoardDAO(){
    list = new ArrayList<Board>();
    cnt = 1;
    init();
    System.out.println("[정보 로드 완료]");
  }

  void init(){
    Board b1 = new Board(cnt++, "작성자1", "2024-02-01", "제목1", "내용1");
    Board b2 = new Board(cnt++, "작성자2", "2024-02-01", "제목2", "내용2");
    Board b3 = new Board(cnt++, "작성자3", "2024-02-01", "제목3", "내용3");

    list.add(b1);
    list.add(b2);
    list.add(b3);
  }

  public int getTotalData(){
    return list.size();
  }

  public Board getOneBoard(int idx){
    return list.get(idx);
  }

  public void createDummies(int size){
    LocalDate date = LocalDate.now();
    for (int i = 0; i < size; i++) {
      Board b = new Board(cnt, "작성자"+cnt, date.plusDays(i).toString(), "제목"+cnt, "내용1"+cnt);
      cnt += 1;
      list.add(b);
    }
    System.out.println("[더미 추가 완료]");
  }

  public void deleteAllData(){
    //list = new ArrayList<Board>();
    list.clear();
    cnt = 1; // 전체 삭제할때만 cnt 1로 초기화했음
    System.out.println("[전체 데이터 삭제완료]");
  }

  public void addOneBoard(String writer, String subject, String contents){
    LocalDate date = LocalDate.now();
    Board b = new Board(cnt++, writer, date.toString(), subject, contents);
    list.add(b);
    System.out.println(b);
    System.out.println("[게시글 1개 추가 완료]");
  }

  public void updateOneBoard(String index, String subject, String contents) {
    int idx = Integer.parseInt(index);
    Board b = getOneBoard(idx);

    b.setSubject(subject);
    b.setContents(contents);
    System.out.println(b);
    System.out.println("[ 게시글 1개 수정 완료]");
  }

  public boolean deleteOneBoard(String index) {

    int idx = -1;

    try {
      idx = Integer.parseInt(index);
      if(idx < 0 || idx>= list.size()) {
        throw new Exception();
      }

      list.remove(idx);
      System.out.println("[ 게시글 1개 삭제 완료]");
      return true;
    }catch(Exception e) {
      System.out.println("[ 게시글 1개 삭제 실패]");
      return false;
    }
  }
}
