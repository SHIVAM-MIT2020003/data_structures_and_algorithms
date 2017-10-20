package Same_occurrence;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SameOccurence solver = new SameOccurence();
        solver.solve(1, in, out);
        out.close();
    }

    static class SameOccurence {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.readInt();
            int m = in.readInt();
            int[] values = IOUtils.readIntArray(in, n);
            boolean[] taken = new boolean[n];
            HashMap<Integer, SameOccurence.Number> posMap = new HashMap<Integer, SameOccurence.Number>();
            for (int i = 0; i < n; ++i) {
                if (!taken[i]) {
                    int c = 0;
                    for (int j = i; j < n; ++j) {
                        if (values[j] == values[i]) {
                            taken[j] = true;
                            c++;
                        }
                    }
                    SameOccurence.Number number = new SameOccurence.Number();
                    number.num = values[i];
                    number.pos = new int[c];
                    int k = 0;
                    for (int j = i; j < n; ++j) {
                        if (values[j] == values[i]) {
                            number.pos[k++] = j;
                        }
                    }
                    posMap.put(values[i], number);
                }
            }
            HashMap<IntPair, Integer> map = new HashMap<IntPair, Integer>();
            for (int i = 0; i < m; ++i) {
                int a = in.readInt();
                int b = in.readInt();
                if (a == b) {
                    out.println((n * (n + 1)) / 2);
                    continue;
                }
                if (a > b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                SameOccurence.Number numA;
                if (posMap.containsKey(a)) {
                    numA = posMap.get(a);
                } else {
                    numA = new SameOccurence.Number();
                    numA.num = -1;
                }
                SameOccurence.Number numB;
                if (posMap.containsKey(b)) {
                    numB = posMap.get(b);
                } else {
                    numB = new SameOccurence.Number();
                    numB.num = -1;
                }
                IntPair pair = new IntPair(numA.num, numB.num);

                if (map.containsKey(pair)) {
                    out.println(map.get(pair));
                    continue;
                }
                int res = RangeCount(numA, numB, values);
                map.put(pair, res);
                out.println(res);
            }
        }

        private int RangeCount(SameOccurence.Number a, SameOccurence.Number b, int[] values) {
            int[] pos = new int[a.pos.length + b.pos.length + 2];
            pos[0] = -1;
            int apos = 0;
            int bpos = 0;
            for (int i = 1; i < pos.length - 1; ++i) {
                if (apos >= a.pos.length) {
                    pos[i] = b.pos[bpos++];
                } else if (bpos >= b.pos.length) {
                    pos[i] = a.pos[apos++];
                } else if (a.pos[apos] < b.pos[bpos]) {
                    pos[i] = a.pos[apos++];
                } else {
                    pos[i] = b.pos[bpos++];
                }
            }
            pos[pos.length - 1] = values.length;
            int acount = 0;
            int bcount = 0;
            int curMin = 0;
            int res = 0;
            for (int i = 1; i < pos.length - 1; ++i) {
                if (values[pos[i]] == a.num) acount++;
                if (values[pos[i]] == b.num) bcount++;
                if (Math.min(acount, bcount) > curMin) {
                    curMin = Math.min(acount, bcount);
                    int r = RangeCount(a.num, b.num, pos, i, acount, bcount, values);
                    res += r;
                }
            }
            for (int i = 1; i < pos.length; ++i) {
                int s = pos[i] - pos[i - 1];
                res += (s * (s - 1)) / 2;
            }
            return res;
        }

        private int RangeCount(int a, int b, int[] pos, int lim, int acount, int bcount, int[] values) {
            int left = 1;
            int right = lim;
            int size = Math.min(acount, bcount);
            if (size < 1) return 0;
            int res = 0;
            while (right < pos.length - 1) {
                if (acount > size || bcount > size) {
                    if (values[pos[left]] == a) acount--;
                    if (values[pos[left]] == b) bcount--;
                    left++;
                } else if (acount < size || bcount < size) {
                    right++;
                    if (right == pos.length - 1) break;
                    if (values[pos[right]] == a) acount++;
                    if (values[pos[right]] == b) bcount++;
                }
                if (right == pos.length - 1) break;
                if (acount == size && bcount == size) {
                    res += (pos[left] - pos[left - 1]) * (pos[right + 1] - pos[right]);
                    right++;
                    if (right == pos.length - 1) break;
                    if (values[pos[right]] == a) acount++;
                    if (values[pos[right]] == b) bcount++;
                }
            }
            return res;
        }

        public static class Number {
            int num;
            int[] pos = new int[0];

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            // InputMismatchException -> UnknownError
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            } else if (c == '+') {
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public static boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }

    static class IOUtils {
        public static int[] readIntArray(InputReader in, int size) {
            int[] res = new int[size];
            for (int i = 0; i < size; ++i) {
                res[i] = in.readInt();
            }
            return res;
        }

    }

    static class IntPair implements Comparable<IntPair> {
        int first;
        int second;

        public IntPair(int a, int b) {
            this.first = a;
            this.second = b;
        }

        public int compareTo(IntPair that) {
            if (first == that.first) {
                return this.second - that.second;
            } else {
                return this.first - that.first;
            }
        }


        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            IntPair pair = (IntPair) o;

            return first == pair.first && second == pair.second;
        }


        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            return result;
        }

    }
}
