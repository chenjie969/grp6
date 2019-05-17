/*
 * 创建日期 2005-8-5
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package sql;

import java.io.*;

import nc.bs.framework.common.Serializer;

/**
 * @nopublish User: ���� Date: 2005-6-2 Time: 15:20:52 InOutUtil���˵��
 */
public class InOutUtil {

	public static int readLine(InputStream in, OutputStream out)
			throws IOException {
		int count = 0;
		for (;;) {
			int b = in.read();

			if (b == -1) {
				break;
			}
			count++;
			out.write(b);
			if (b == '\n') {
				break;
			}
		}
		return count;
	}

	public static byte[] serialize(Serializable s) throws IOException {
		if (s == null)
			return null;
		return Serializer.serialize(s);
	}

	public static Serializable deserialize(byte[] ba) {
		return Serializer.deserialize(ba);
	}
}
