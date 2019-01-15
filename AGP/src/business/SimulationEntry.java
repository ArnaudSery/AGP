package business;

public class SimulationEntry {

		private int numberDay;
		private int numberExcursion;
		private String keyWord;
		private int totalCost;
		private int numberHourMax;
		private String intensity;
		private boolean confort;
		
		public SimulationEntry() {
			this.numberDay =  3;
			this.numberExcursion = 2;
			this.keyWord = "";
			this.totalCost = 1000;
			this.intensity = "normal";// normal or hight
			if(intensity.compareTo("normal") == 0) {
				this.numberHourMax = 6;
			}
			else {
				this.numberHourMax = 10;
			}
			this.confort = true;
		}

		public SimulationEntry(int numberDay, int numberExcursion, String keyWord, int totalCost, String intensity, boolean confort) {
			this.numberDay =  numberDay;
			this.numberExcursion = numberExcursion;
			if(numberDay < numberExcursion) {
				this.numberExcursion = this.numberDay;
				System.out.println("numberExcursion = numberDay");
			}
			this.keyWord = keyWord;
			this.totalCost = totalCost;
			this.intensity = intensity;
			if(intensity.compareTo("normal") == 0) {
				this.numberHourMax = 6;
			}
			else {
				this.numberHourMax = 10;
			}
			this.confort = confort;
		}

		public String getIntensity() {
			return intensity;
		}

		public void setIntensity(String intensity) {
			this.intensity = intensity;
		}

		public void setConfort(boolean confort) {
			this.confort = confort;
		}

		public boolean isConfort() {
			return confort;
		}

		public int getNumberDay() {
			return numberDay;
		}

		public void setNumberDay(int numberDay) {
			this.numberDay = numberDay;
		}

		public int getNumberExcursion() {
			return numberExcursion;
		}

		public void setNumberExcursion(int numberExcursion) {
			this.numberExcursion = numberExcursion;
		}

		public String getKeyWord() {
			return keyWord;
		}

		public void setKeyWord(String keyWord) {
			this.keyWord = keyWord;
		}

		public int getTotalCost() {
			return totalCost;
		}

		public void setTotalCost(int cost) {
			this.totalCost = cost;
		}

		public int getNumberHourMax() {
			return numberHourMax;
		}

		public void setNumberHourMax(int numberHourMax) {
			this.numberHourMax = numberHourMax;
		}
		
}
