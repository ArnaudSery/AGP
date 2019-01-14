package business;

public class SimulationEntry {

		private int numberDay;
		private int numberExcursion;
		private String keyWord;
		private int totalCost;
		//private int intensity;
		
		public SimulationEntry() {
			this.numberDay =  3;
			this.numberExcursion = 2;
			this.keyWord = "";
			this.totalCost = 1000;
		}

		public SimulationEntry(int numberDay, int nulberExcursion, String keyWord, int totalCost) {
			this.numberDay =  numberDay;
			this.numberExcursion = nulberExcursion;
			this.keyWord = keyWord;
			this.totalCost = totalCost;
			//this.intensity = intensity;
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
		
}
