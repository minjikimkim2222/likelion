package org.day25;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WWWRead {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.naver.com/");

        InputStream urlInput = url.openStream();

        // url에서 한줄씩 입력받아서 출력 (한줄 -> BufferedReader)
        BufferedReader br = new BufferedReader(new InputStreamReader(urlInput));

        String msg = null;
        while ((msg = br.readLine()) != null){
            System.out.println(msg);
        }

    }
}
