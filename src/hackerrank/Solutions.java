package hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Solutions {

	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

		List<Integer> scores = Arrays.asList(0, 0);

		for (int i = 0; i < 3; i++) {
			if (a.get(i) > b.get(i)) {
				scores.set(0, scores.get(0) + 1);
			}
			if (a.get(i) < b.get(i)) {
				scores.set(1, scores.get(1) + 1);
			}
		}

		return scores;
	}

	static long aVeryBigSum(long[] ar) {

		long bigSum = 0;

		for (int i = 0; i < ar.length; i++) {
			bigSum += ar[i];
		}

		return bigSum;
	}

	static int diagonalDifference(int[][] arr) {

		int diagDiff = 0;
		int n = arr.length;

//            1    2    3    4      i = 0;
//            5    6    7    8      i = 1;
//            9    10  11  12    i = 2;
//            13  14  15  16    i = 3;
		int dl = 0, dr = 0;

		for (int i = 0; i < n; i++) {
			dl += arr[i][i];
			dr += arr[i][n - 1 - i];
		}

		diagDiff = Math.abs(dl - dr);

		return diagDiff;
	}

	static void plusMinus(int[] arr) {

		int n = arr.length;
		int[] nrs = new int[3];

//            ratio of x = x/n;
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				nrs[0]++;
			} else if (arr[i] < 0) {
				nrs[1]++;
			} else {
				nrs[2]++;
			}
		}

		for (int i = 0; i < nrs.length; i++) {
			double ratio = (double) nrs[i] / n;
			System.out.println(Math.round(ratio * 1000000d) / 1000000d);
		}
	}

	static int simpleArraySum(int[] ar) {

		int sum = 0;

		for (int i = 0; i < ar.length; i++) {
			sum += ar[i];
		}

		return sum;
	}

	static void staircase(int n) {

		String[] s = new String[n];

		for (int i = 0; i < n; i++) {
			s[i] = "";
			for (int j = 0; j < n; j++) {
				if (j < n - (i + 1)) {
					s[i] += " ";
				}
				if (j >= n - (i + 1)) {
					s[i] += "#";
				}
			}
			System.out.println(s[i]);
		}
	}

	static void miniMaxSum(int[] arr) {

		Arrays.sort(arr);

		long minSum = 0, maxSum = 0;

		for (int i = 0; i < 5; i++) {
			if (i <= 3) {
				minSum += arr[i];
			}
			if (i > 0) {
				maxSum += arr[i];
			}
		}
		System.out.println(minSum + " " + maxSum);
	}

	static int birthdayCakeCandles(int[] ar) {

		int candlesBlown = 0;
		Arrays.sort(ar);

		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == ar[ar.length - 1]) {
				candlesBlown++;
			}
		}

		return candlesBlown;
	}

	static String timeConversion(String s) {

		SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm:ssaa", Locale.ENGLISH);
		SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");

		String militaryTime;
		try {
			militaryTime = outputFormat.format(inputFormat.parse(s));
			return militaryTime;
		} catch (ParseException ex) {
		}

		return "error";
	}

	static int[] gradingStudents(int[] grades) {

		// sample input = 73,67,38,33
		// sample output = 75,67,40,33
		int[] roundedGrades = new int[grades.length];

		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= 38) {
				if (grades[i] % 5 > 2) {
					roundedGrades[i] = grades[i] + (5 - (grades[i] % 5));
				} else {
					roundedGrades[i] = grades[i];
				}
			} else {
				roundedGrades[i] = grades[i];
			}

			System.out.println(roundedGrades[i]);
		}

		return roundedGrades;
	}

	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

		int applesOnHouse = 0, orangesOnHouse = 0;

		for (int i = 0; i < apples.length; i++) {
			if (s <= a + apples[i] && a + apples[i] <= t) {
				applesOnHouse++;
			}
		}

		for (int i = 0; i < oranges.length; i++) {
			if (t >= b + oranges[i] && b + oranges[i] >= s) {
				orangesOnHouse++;
			}
		}
		System.out.println(applesOnHouse + "\n" + orangesOnHouse);
	}

	static String kangaroo(int x1, int v1, int x2, int v2) {

		// sample input 0,3,4,2
		// sample output: YES
		if (x1 < x2 && v1 < v2) {
			return "NO";
		}

		int k1pos = x1, k2pos = x2;

		while (k1pos <= (v1 * x2)) {

			if (k1pos == k2pos) {
				return "YES";
			}

			k1pos += v1;
			k2pos += v2;
		}

		return "NO";
	}

	static int getTotalX(int[] a, int[] b) {

		int factorOfBoth = 0;
		Arrays.sort(a);
		Arrays.sort(b);

		int rangeStart = a[a.length - 1];
		int rangeEnd = b[0];

		for (int i = rangeStart; i <= rangeEnd; i++) {
			int sum_mod = 0;
			for (int j = 0; j < a.length; j++) {
				sum_mod += i % a[j];
			}
			for (int k = 0; k < b.length; k++) {
				sum_mod += b[k] % i;
			}

			if (sum_mod == 0) {
				++factorOfBoth;
			}
		}

		return factorOfBoth;
	}

	static int[] breakingRecords(int[] scores) {

		int min = scores[0], max = scores[0];
		int minCnt = 0, maxCnt = 0;

		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < min) {
				minCnt++;
				min = scores[i];
			}
			if (scores[i] > max) {
				max = scores[i];
				maxCnt++;
			}
		}

		int[] recordsCnt = {maxCnt, minCnt};

		return recordsCnt;
	}

	static int birthday(List<Integer> s, int d, int m) {

		if (s.size() == 1 && s.get(0) == d) {
			return 1;
		}

		int waysToDivide = 0;

		for (int i = 0; i <= s.size() - m; i++) {
			int mSum = 0;
			for (int j = i; j < m + i; j++) {
				mSum += s.get(j);
			}
			if (mSum == d) {
				waysToDivide++;
			}
		}

		return waysToDivide;
	}

	static int divisibleSumPairs(int n, int k, int[] ar) {
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (i < j && (((ar[i] + ar[j]) % k) == 0)) {
					count++;
				}
			}
		}
		return count;
	}

	static int migratoryBirds(List<Integer> arr) {
		int typeId = 0;

		int[] typeCnt = new int[5];

		for (int i = 0; i < arr.size(); i++) {
//			switch(arr.get(i)){
//					case 1: typeCnt[0]++; break;
//					case 2: typeCnt[1]++; break;
//					case 3: typeCnt[2]++; break;
//					case 4: typeCnt[3]++; break;
//					case 5: typeCnt[4]++; break;
//				}
			typeCnt[arr.get(i) - 1]++;
		}

		int max = 0;
		for (int i = 0; i < typeCnt.length; i++) {
			if (max < typeCnt[i]) {
				max = typeCnt[i];
			}
		}

		for (int i = 0; i < typeCnt.length; i++) {
			if (typeCnt[i] == max) {
				typeId = i + 1;
				break;
			}
		}

		return typeId;
	}

	static String dayOfProgrammer(int year) {
		StringBuilder date = new StringBuilder();
		int dd = 13;

		if (year == 1918) {
			dd = 26;
		}
		if (year < 1918 && year % 4 == 0) {
			dd--;
		}
		if (year > 1918 && year % 4 == 0 && year % 100 != 0 || year > 1918 && year % 400 == 0) {
			dd--;
		}

		date.append(dd);
		date.append(".09.");
		date.append(year);

		return date.toString();
	}

	static void bonAppetit(List<Integer> bill, int k, int b) {

		int shouldCharge = 0;
		for (int i = 0; i < bill.size(); i++) {
			if (i != k) {
				shouldCharge += bill.get(i);
			}
		}
		shouldCharge = shouldCharge / 2;

		if (shouldCharge == b) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(Math.abs(shouldCharge - b));;
		}
	}

	static int pageCount(int n, int p) {
		return Math.min(p / 2, n / 2 - p / 2);
	}

	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		Arrays.sort(keyboards);
		Arrays.sort(drives);

		if (keyboards[0] + drives[0] > b) {
			return -1;
		}

		int moneySpent = 0;
		int maxSpent = 0;

		for (int i = 0; i < keyboards.length; i++) {
			for (int j = 0; j < drives.length; j++) {
				if (keyboards[i] + drives[j] <= b) {
					moneySpent = keyboards[i] + drives[j];
				}
				if (maxSpent < moneySpent) {
					maxSpent = moneySpent;
				}
			}
		}

		return maxSpent;
	}

	static String catAndMouse(int x, int y, int z) {
		if (Math.abs(x - z) < Math.abs(y - z)) {
			return "Cat A";
		}
		if (Math.abs(x - z) > Math.abs(y - z)) {
			return "Cat B";
		}
		if (Math.abs(x - z) == Math.abs(y - z)) {
			return "Mouse C";
		}

		return null;
	}

	static int pickingNumbers(List<Integer> a) {

		a.sort(Comparator.naturalOrder());

		int maxArrayCnt = 0;
		int tmp = 0;

		for (int i = 0; i < a.size(); i++) {
			for (int j = i; j < a.size(); j++) {
				if (Math.abs(a.get(i) - a.get(j)) <= 1) {
					tmp++;
				}
			}
			if (maxArrayCnt < tmp) {
				maxArrayCnt = tmp;
			}
			tmp = 0;
		}

		return maxArrayCnt;
	}

	static int hurdleRace(int k, int[] height) {

		Arrays.sort(height);

		int potionCount = height[height.length - 1] - k;
		if (potionCount < 0) {
			potionCount = 0;
		}

		return potionCount;
	}

	static int designerPdfViewer(int[] h, String word) {

		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		Map<String, Integer> abc = new HashMap<>();
		for (int i = 0; i < alphabet.length(); i++) {
			abc.put("" + alphabet.charAt(i), h[i]);
		}

		int w = word.length(), maxH = 0;
		for (int i = 0; i < word.length(); i++) {
			if (maxH < abc.get("" + word.charAt(i))) {
				maxH = abc.get("" + word.charAt(i));
			}
		}

		return w * maxH;
	}

	static int utopianTree(int n) {
		int height = 0;

		for (int i = 0; i <= n; i++) {
			if (i % 2 == 1) {
				height += height;
			}
			if (i % 2 == 0) {
				height += 1;
			}
		}

		return height;
	}

	static boolean isAnagram(String a, String b) {

		char[] aarr = a.toLowerCase().toCharArray();
		char[] barr = b.toLowerCase().toCharArray();

		if (aarr.length != barr.length) {
			return false;
		}

		// bubble sorting
		int n = aarr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (aarr[j] > aarr[j + 1]) {
					char tmp1 = aarr[j];
					aarr[j] = aarr[j + 1];
					aarr[j + 1] = tmp1;
				}
				if (barr[j] > barr[j + 1]) {
					char tmp2 = barr[j];
					barr[j] = barr[j + 1];
					barr[j + 1] = tmp2;
				}
			}
		}

		for (int i = 0; i < aarr.length; i++) {
			if (aarr[i] != barr[i]) {
				return false;
			}
		}

		return true;
	}

	static void isPalindrome(String word) {
//		char[] arrWord = word.toLowerCase().toCharArray();
//		StringBuilder drow = new StringBuilder();
//
//		for (int i = word.length() - 1; i >= 0; i--) {
//			drow.append(arrWord[i]);
//		}
//		if (drow.toString().equals(word.toLowerCase())) { System.out.println("Yes"); } 
//		else { System.out.println("No"); }

		boolean palindrome = true;
		for (int i = 0; i < word.length() / 2; i++) {
			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
				palindrome = false;
			}
		}

		if (palindrome) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	// Bubble sort
	static void countSwaps(int[] a) {
		int swaps = 0;

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					swaps++;
				}
			}
		}

		System.out.println("Array is sorted in " + swaps + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[a.length - 1]);
	}

	static int makingAnagrams(String s1, String s2) {
		int[] arr = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			arr[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length(); i++) {
			arr[s2.charAt(i) - 'a']--;
		}

		int ans = 0;
		for (int i = 0; i < 26; i++) {
			ans += Math.abs(arr[i]);
		}
		return ans;
	}

	static String multiplyToNumber(int[] arr, int nr) {

		int number = nr;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] * arr[j] == number) {
					return "" + arr[i] + " " + arr[j];
				}
			}

		}
		return "No pair of numbers has a product of  " + nr + " in the given array.";
	}

	static int beautifulDays(int i, int j, int k) {
		int cnt = 0;

		StringBuilder lRevStr = new StringBuilder();
		int lRev;

		for (int l = i; l <= j; l++) {
			if (lRevStr.length() > 0) {
				lRevStr.delete(0, lRevStr.length());
			}
			lRevStr.append(l);

			lRev = Integer.parseInt("" + lRevStr.reverse());

			if (Math.abs(l - lRev) % k == 0) {
				cnt++;
			}
		}

		return cnt;
	}

	static int viralAdvertising(int n) {
		int rec = 5;
		int liked;
		int cum = 0;

		for (int i = 0; i < n; i++) {
			if (i > 0) {
				rec = (rec / 2) * 3;
			}
			liked = (rec / 2);

			// d1 = 2, d2 =3, d3 =4
			cum += liked;
		}

		return cum;
	}

	static int saveThePrisoner(int n, int m, int s) {

//		int nIterator = s;
//		for (int i = 0; i < m; i++) {
//			if(i == m-1)  return nIterator;
//			nIterator++;	
//			if(nIterator == n+1) nIterator = 1;
//		}
		int poisoned = (s + m - 1) % n;
		if (poisoned == 0) {
			poisoned = n;
		}

		return poisoned;
	}

	static int findDigits(int n) {
		int divisorsCnt = 0;

		String nr = "" + n;

		for (int i = 0; i < nr.length(); i++) {
			if (Integer.parseInt("" + nr.charAt(i)) != 0 && n % Integer.parseInt("" + nr.charAt(i)) == 0) {
				divisorsCnt++;
			}
		}

		return divisorsCnt;
	}

	static int equalizeArray(int[] arr) {

//		if (arr.length == 0) {
//			return 0;
//		}
//
//		Arrays.sort(arr);
//
//		int previous = arr[0];
//		int popular = arr[0];
//		int count = 1;
//		int maxCount = 1;
//
//		for (int i = 1; i < arr.length; i++) {
//			if (arr[i] == previous) {
//				count++;
//			} else {
//				if (count > maxCount) {
//					popular = arr[i - 1];
//					maxCount = count;
//				}
//				previous = arr[i];
//				count = 1;
//			}
//		}
//		int mostPopular = count > maxCount ? arr[arr.length - 1] : popular;
//
//		int mPcnt = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i] == mostPopular) mPcnt++;
//		}
//		int deletions = arr.length - mPcnt;

		Map<Integer, Integer> arrMap = new HashMap<>();
		
		int maxCount = 1;
		
		// like a foreach() statement
		for (int item : arr){
			// add elements to the Map as KEYS, each with an initial VALUE
			// of 1 -> this will be the counter to which we add later
			if(!arrMap.containsKey(item)) arrMap.put(item, 1);
			else{
				// if the item (KEY) is already in the Map, add to its VALUE (count) +1
				arrMap.put(item, arrMap.get(item) + 1);
				// find the the highest count (VALUE) as we iterate through the Map
				// using the KEY (item) and assign it to maxCount
				if(arrMap.get(item) > maxCount) maxCount = arrMap.get(item);
			}
		}
		
		return arr.length - maxCount;
	}
	
	static int minimumDistances(int[] a) {
		
		int minDist = a.length;
		
		// ex. 7 1 3 4 1 7
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length ; j++) {
				if(a[i] == a[j] && Math.abs(j-i) < minDist) minDist = j-i;
			}
		}
		
		if(minDist == a.length) return -1;
		
		return minDist;
	}
	
}
