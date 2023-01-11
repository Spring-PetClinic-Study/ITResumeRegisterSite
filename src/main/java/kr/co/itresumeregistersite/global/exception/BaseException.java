package kr.co.itresumeregistersite.global.exception;

// RuntimeException을 상속받은 추상 클래스로 설정
public abstract class BaseException extends RuntimeException{

    // 앞으로 정의할 모든 커스텀 예외의 부모 클래스로, 앞으로 생성할 커스텀 예외 클래스들을 BaseException 타입으로 처리할 수 있도록 하기 위해 생성
    // BaseException은 BaseExceptionType을 반환하는 getExceptionType 메서드를 갖음
    // 이는 이후 Enum으로 설정하여 에러 메세지와 Http 상태코드, 그리고 나만의 에러코드를 설정해주어 관리해주도록 함
    public abstract BaseExceptionType getExceptionType();
}
