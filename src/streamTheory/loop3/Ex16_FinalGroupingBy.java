package streamTheory.loop3;


public class Ex16_FinalGroupingBy {
    public static void main(String[] args) {
        Student[] stuArr = {
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),

                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200)
        };
        System.out.println("1. 단순그룹화(반별로 그룹화)");


        System.out.println("\n2. 단순그룹화(성적별로 그룹화)");


        System.out.println("\n3. 단순그룹화 + 통계(성적별 학생수)");


        System.out.println("\n4. 다중그룹화(학년별, 반별)");


        System.out.println("\n5. 다중그룹화 + 통계(학년별, 반별 1등)");


        System.out.println("\n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)");
    }
}
