package business;

public class SimulationEntry {

	
		private String typeVisit;
		private String keyWord;
		
		private int numberDay;
		private String intensity;
		private int numberDayExcursion;
		private int priceMin;
		private int priceMax;
		
		public SimulationEntry() {
			
			this.typeVisit = "";
			this.keyWord = "";
			
			this.numberDay = 5;
			this.intensity = "medium";
			if(intensity.compareTo("hight") == 0) {
				this.numberDayExcursion = numberDay;
			}
			else if(intensity.compareTo("medium") == 0) {
				this.numberDayExcursion = numberDay/2;
			}
			else if(intensity.compareTo("low") == 0) {
				this.numberDayExcursion = numberDay/4;
			}
			this.priceMin = 1000;
			this.priceMax = 2000;
		}
		

		public SimulationEntry(String typeVisit, String keyWord, int numberDay, String intensity, int numberDayExcursion, int priceMin, int priceMax) {
			
			this.typeVisit = "";
			this.keyWord = "";
			
			this.numberDay = 3;
			this.intensity = "hight";
			if(intensity.compareTo("hight") == 0) {
				this.numberDayExcursion = numberDay;
			}
			else if(intensity.compareTo("medium") == 0) {
				this.numberDayExcursion = numberDay/2;
			}
			else if(intensity.compareTo("low") == 0) {
				this.numberDayExcursion = numberDay/4;
			}
			this.priceMin = 1000;
			this.priceMax = 2000;

		}


		public String getTypeVisit() {
			return typeVisit;
		}


		public void setTypeVisit(String typeVisit) {
			this.typeVisit = typeVisit;
		}


		public String getKeyWord() {
			return keyWord;
		}


		public void setKeyWord(String keyWord) {
			this.keyWord = keyWord;
		}


		public int getNumberDay() {
			return numberDay;
		}


		public void setNumberDay(int numberDay) {
			this.numberDay = numberDay;
		}


		public String getIntensity() {
			return intensity;
		}


		public void setIntensity(String intensity) {
			this.intensity = intensity;
		}


		public int getNumberDayExcursion() {
			return numberDayExcursion;
		}


		public void setNumberDayExcursion(int numberDayExcursion) {
			this.numberDayExcursion = numberDayExcursion;
		}


		public int getPriceMin() {
			return priceMin;
		}


		public void setPriceMin(int priceMin) {
			this.priceMin = priceMin;
		}


		public int getPriceMax() {
			return priceMax;
		}


		public void setPriceMax(int priceMax) {
			this.priceMax = priceMax;
		}
		
		
		
		
}
