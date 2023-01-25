package com.isa.blood_transfusion.service;

public interface QrCodeGeneratorService {
    boolean generateQrCode(String qrCodeContent, String filePath, int width, int height);
}
