package vn.wae.spring.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringUtils {
	public static char[] VIETNAMESE_CHARACTERS = "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝÝàáâãèéêìíòóôõùúýýĂăĐđĨĩŨũƠơƯưẠạẢảẤấẦầẨẩẪẫẬậẮắẰằẲẳẴẵẶặẸẹẺẻẼẽẾếỀềỂểỄễỆệỈỉỊịỌọỎỏỐốỒồỔổỖỗỘộỚớỜờỞởỠỡỢợỤụỦủỨứỪừỬửỮữỰựỲỳỴỵỶỷỸỹ"
			.toCharArray();
	public static char[] SIMPLIFIED_VIETNAMESE_CHARACTERS = "AAAAEEEIIOOOOUUYYaaaaeeeiioooouuyyAaDdIiUuOoUuAaAaAaAaAaAaAaAaAaAaAaAaEeEeEeEeEeEeEeEeIiIiOoOoOoOoOoOoOoOoOoOoOoOoUuUuUuUuUuUuUuYyYyYyYy"
			.toCharArray();
	public static Map<String, String> list_filter_vn_char = new HashMap<>();

	public static String getTitleFilterCharVn(String data) {
		char[] buff = data.replaceAll(" - ", " ").toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < buff.length; i++) {
			char c = buff[i];
			int j = Arrays.binarySearch(VIETNAMESE_CHARACTERS, c);
			if (j >= 0) {
				sb.append(SIMPLIFIED_VIETNAMESE_CHARACTERS[j]);
			} else {
				sb.append(c);
			}
		}
		String str = sb.toString().trim().replaceAll("[(&+)(\\s+)]", "-").toLowerCase();
		return str;
	}
}
