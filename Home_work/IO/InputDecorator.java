package Home_work.IO;

import java.io.*;

class InputDecorator extends FilterInputStream {

    protected InputDecorator(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {
        byte key = 121;
        int data;
        try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
            while ((data = in.read(b)) != -1) {
                for (int x = 0; x < b.length; x++) {
                    b[x] ^= key;
                }
                byteArray.write(b, 0, data);
            }
            System.out.println("Дешифрованный текст файла: " + byteArray);

            return in.read(b);
        }
    }
}
