package com.isa.blood_transfusion.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
@Setter
@AllArgsConstructor
@Service
public class QrCodeGeneratorServiceImpl implements QrCodeGeneratorService {

    @Override
    public boolean generateQrCode(String qrCodeContent, String filePath, int width, int height) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeContent, BarcodeFormat.QR_CODE, width, height);
            Path path = Paths.get(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            return true;
        } catch (WriterException e) {
            System.out.println("Error");
        } catch (IOException e) {
            System.out.println("Error");
        }
        return false;
    }
}
