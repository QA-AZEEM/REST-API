package azt.rest_ful_api.model;

public class Items {

	private String name;
	private Data data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public static class Data {
		
		private int year;
		private double price;
		private String cpuModel;
		private String hardDisk;

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getCpuModel() {
			return cpuModel;
		}

		public void setCpuModel(String cpuModel) {
			this.cpuModel = cpuModel;
		}

		public String getHardDisk() {
			return hardDisk;
		}

		public void setHardDisk(String hardDisk) {
			this.hardDisk = hardDisk;
		}

	}
}
