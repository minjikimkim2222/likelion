package org.day21;

// SecurityConfig.java 파일
public final class SecurityConfig {
    private static final String ENCRYPTION_KEY = "minjiki2";

    private SecurityConfig() {
        // 생성자를 private으로 선언하여 외부에서 인스턴스화 방지
    }

    public static String getEncryptionKey() {
        return ENCRYPTION_KEY;
    }
}

// Main.java 파일
class Main {
    public static void main(String[] args) {
        String encryptionKey = SecurityConfig.getEncryptionKey();
        System.out.println("암호화 키: " + encryptionKey);

    }
}