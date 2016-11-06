package Easy;
import java.math.BigInteger;
public class AddStrings {
    public String addStrings(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        a = a.add(b);
        return a.toString();
    }
}