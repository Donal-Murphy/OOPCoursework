package ie.atu.sw;

import java.util.Arrays;

public class CodeRunnerTemplate {
	
	public int[] seriesUp(int n) {
		int[] series = new int[n* ((n+1)/2)];
		int k = 0;
		while (k < series.length) {
			for (int i = 0; i<=n; i++) {
				for (int j = 1; j <= series[i]; j++) {
					series[k] = j;
					k++;
				}
			}
		}
		return series;
	}

	public static void main(String[] args) {
		CodeRunnerTemplate test = new CodeRunnerTemplate();
		System.out.println(test.seriesUp(4));
		
	}
	
}
