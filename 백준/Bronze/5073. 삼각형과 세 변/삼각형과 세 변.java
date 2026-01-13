import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정삼각형: Equilateral
//이등변삼각형: Isosceles
//그외 삼격형: Scalene
//삼각형이 아닐 때: Invalid (가장 긴 변의 길이가 나머지 두 변의 길이 합보다 짧거나 같을 때)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sideA = Integer.parseInt(st.nextToken());
            int sideB = Integer.parseInt(st.nextToken());
            int sideC = Integer.parseInt(st.nextToken());

            if(sideA == 0 && sideB == 0 && sideC == 0) {
                break;
            }

            int maxLength = Math.max(Math.max(sideA, sideB),sideC);
            if((sideA + sideB + sideC) > 2 * maxLength){ //삼각형 성립
                if(sideA == sideB && sideB == sideC) {
                    System.out.println("Equilateral");
                }else if(sideA == sideB || sideB == sideC || sideA == sideC) {
                    System.out.println("Isosceles");
                }else{
                    System.out.println("Scalene");
                }
            }else{ //삼각형 아님
                System.out.println("Invalid");
            }

        }

    }
}