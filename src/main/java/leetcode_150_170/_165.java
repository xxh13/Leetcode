package leetcode_150_170;

import org.junit.Test;

public class _165 {

	@Test
	public void test() {
		assert compareVersion("0.1", "1.1") == -1;
		assert compareVersion("1.0", "1") == 0;
		assert compareVersion("1.1", "1.1.2") == -1;

		assert Integer.parseInt("01") == 1;
	}

	public int compareVersion(String version1, String version2) {
		String[] versionArray1 = version1.split("\\.");
		String[] versionArray2 = version2.split("\\.");

		int i = 0, j = 0;

		while (i < versionArray1.length && j < versionArray2.length) {
			if (Integer.parseInt(versionArray1[i]) < Integer.parseInt(versionArray2[j])) {
				return -1;
			} else if (Integer.parseInt(versionArray1[i]) > Integer.parseInt(versionArray2[j])) {
				return 1;
			} else {
				i++;
				j++;
			}
		}

		if (i < versionArray1.length && j == versionArray2.length) {
			while (i < versionArray1.length) {
				if (Integer.parseInt(versionArray1[i]) != 0) {
					return 1;
				}
				i++;
			}
			return 0;
		}

		if (i == versionArray1.length && j < versionArray2.length) {
			while (j < versionArray2.length) {
				if (Integer.parseInt(versionArray2[j]) != 0) {
					return -1;
				}
				j++;
			}
			return 0;
		}

		return 0;
	}

}
