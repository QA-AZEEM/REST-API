package azt.rest_ful_api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateItemResponse {

	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("data")
	private Data data;

	@JsonProperty("createdAt")
	private String createdAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Data {

		@JsonProperty("year")
		private int year;

		@JsonProperty("price")
		private double price;

		@JsonProperty("cpuModel")
		private String cpuModel;

		@JsonProperty("hardDisk")
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
