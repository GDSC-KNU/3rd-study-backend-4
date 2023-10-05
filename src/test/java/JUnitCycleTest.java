import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll // 전체 테스트 시작 전 1회 실행(클래스 레벨), 한 번만 호출 되어야 하므로 static 선언
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach // 테스트 케이스 시작 전마다 실행(메서드 레벨), 여러번 호출 할거라 static 하면 안됨
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    @AfterAll // 전체 테스트 종료 후 1회 실행(클래스 레벨), 마찬가지로 static 선언
    static void afterAll() {
        System.out.println("@AfterAll");
    }

    @AfterEach // 테스트 케이스 종료 직전마다 실행(메서드 레벨), 마찬가지로 static 아님
    public void afterEach() {
        System.out.println("@AfterEach");
    }
}
