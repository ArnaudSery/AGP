package business;

public class SimulationEntry {

		private int numberDay;
		private int numberExcursion;
		private String keyWord;
		private int totalCost;
		private int intensity;
		private int numberHourMax;
		private String confort;
		
		public SimulationEntry() {
			this.numberDay =  3;
			this.numberExcursion = 2;
			this.keyWord = "";
			this.totalCost = 1000;
			this.intensity = 10;
			this.confort = "normal";// normal or hight
			if(confort.compareTo("normal") == 0) {
				this.numberHourMax = 6;
			}
			else {
				this.numberHourMax = 10;
			}
		}

		public SimulationEntry(int numberDay, int numberExcursion, String keyWord, int totalCost, int intensity, String confort) {
			this.numberDay =  numberDay;
			this.numberExcursion = numberExcursion;
			if(numberDay < numberExcursion) {
				this.numberExcursion = this.numberDay;
				System.out.println("numberExcursion = numberDay");
			}
			this.keyWord = keyWord;
			this.totalCost = totalCost;
			this.intensity = intensity;
			this.confort = confort;
			if(confort.compareTo("normal") == 0) {
				this.numberHourMax = 6;
			}
			else {
				this.numberHourMax = 10;
			}
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
		
		public int getIntensity() {
			return intensity;
		}

		public void setIntensity(int intensity) {
			this.intensity = intensity;
		}

		public int getNumberHourMax() {
			return numberHourMax;
		}

		public void setNumberHourMax(int numberHourMax) {
			this.numberHourMax = numberHourMax;
		}
		
}
