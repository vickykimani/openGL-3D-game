package models;

public class RawModel {
	
	private int vaoID;
	private int vertexCount;

	public RawModel(int vaoID, int vertexCount) {
		this.vaoID = vaoID;
		this.vertexCount = vertexCount;
	}
	
	public int getVaoID() {
		return vaoID;
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public RawModel getRawModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getTexture() {
		// TODO Auto-generated method stub
		return null;
	}


}
