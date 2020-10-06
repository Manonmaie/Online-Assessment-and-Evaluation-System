package com.urest.v1.authoring_module.uploadImage;

public class UploadFileResponse {
    private String url;

    public UploadFileResponse(String url) {
        this.url = url;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	// Getters and Setters (Omitted for brevity)
}