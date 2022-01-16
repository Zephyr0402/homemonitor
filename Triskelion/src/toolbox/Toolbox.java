package toolbox;

import java.util.zip.*;

public class Toolbox {
    public static long getCRC32Checksum(byte[] bytes) {
        Checksum crc32 = new CRC32();
        crc32.update(bytes, 0, bytes.length);
        return crc32.getValue();
    }

    public static byte[] getSmallerByteArray(byte[] largerArray, int length) {
        if (largerArray.length < length) {
            return null;
        }
        byte[] smallerArray = new byte[length];
        for (int i = 0; i < length; i++) {
            smallerArray[i] = largerArray[i];
        }
        return smallerArray;
    }
}
