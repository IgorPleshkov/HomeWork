package Home_work.IO;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class IODecorator extends FilterOutputStream {

    public IODecorator(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {
        byte key = 121;
        for (int x = 0; x < b.length; x++) {
            b[x] ^= key;
        }
        out.write(b);
    }
}
