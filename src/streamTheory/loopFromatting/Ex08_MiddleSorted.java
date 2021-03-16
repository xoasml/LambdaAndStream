package streamTheory.loopFromatting;

public class Ex08_MiddleSorted {
    /*      MiddleStu Class에는 아래와 같이 compareTo가 오버라이딩 되어있다.
     *     @Override
     *     public int compareTo(MiddleStu o) {
     *         return o.totalScore - this.totalScore;
     *     }
     */

    public static void main(String[] args) {
        MiddleStu[] stusArr = {
                new MiddleStu("김자바", 1, 200),
                new MiddleStu("안자바", 2, 100),
                new MiddleStu("박자바", 2, 150),
                new MiddleStu("소자바", 1, 200),
                new MiddleStu("이자바", 3, 300),
                new MiddleStu("나자바", 3, 290),
                new MiddleStu("감자바", 3, 180)
        };
    }
}
