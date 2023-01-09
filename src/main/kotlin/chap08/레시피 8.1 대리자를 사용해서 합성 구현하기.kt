package chap08

import org.jetbrains.annotations.NotNull

/**
 * 문제 : 다른 클래스의 인스턴스가 포함된 클래스를 만들고, 그 클래스에 연산을 위임하고 싶다
 * 해법 : 연산을 위임할 메소드가 포함된 인터페이스를 만들고, 클래스에서 해당 인터페이스를 구현한 다음,
 * by 키워드를 사용해 바깥쪽에 래퍼 클래스르 만든다
 *
 * by 키워드는 포함된 객체에 있는 모든 public 함수를 이 객체를 담고 있는 컨테이너를 통해 노출할 수 있다.
 */

interface Dialable {
    fun dial(number:String): String
}

class Phone: Dialable {
    override fun dial(number: String) =
        "Dialing $number..."
}

interface Snappable {
    fun takePicture(): String
}

class Camera : Snappable {
    override fun takePicture() =
        "Taking picture..."
}

/**
 * SmartPhone 클래스가 다음과 같이 생성자에서 Phone과 Camera를 인스턴스화하고 모든 public 함수를
 * Phone과 Camera 인스턴스에 윙미하도록 정의할 수 있다
 */

class SmartPhone(
    private val phone: Dialable = Phone(),
    private val camera: Snappable = Camera()
): Dialable by phone, Snappable by camera


/**
 * 위 코드를 디컴파일하면 다음과 같이 생겼다
public final class SmartPhone implements Dialable, Snappable {
    private final Dialable phone;
    private final Snappable camera;

    public SmartPhone(@NotNull Dialable phone, @NotNull Snappable camera){
        //...
        this.phone = phone;
        this.camera = camera;
    }

    @NotNull
    public String dial(@NotNull String number){
        return this.phone.dial(number);
    }

    @NotNull
    public String takePicture(){
        return this.camera.takePicture();
    }
    //...
}
 */
