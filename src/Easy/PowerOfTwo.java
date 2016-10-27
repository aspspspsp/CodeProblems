package Easy;

//If a number is power of 2, then its highly bit is 1 and there is only one 1. Therefore, n & (n-1) is 0.
public class PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
      return (n > 0) && ((n & (n - 1)) == 0);
  }
}
