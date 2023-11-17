package com.project.carPoor.controller;


import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import com.project.carPoor.repository.B64ImgReplacedElementFactory;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
@Controller
public class PdfRender {

    private final B64ImgReplacedElementFactory b64ImgReplacedElementFactory;


    @PostMapping("/pdf")
    public ByteArrayOutputStream generatePdfFromHtml(@RequestBody String dynamicHtml, HttpServletResponse response)
            throws DocumentException, IOException {

        String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //        OutputStream outputStream = new FileOutputStream(outputFolder);
        log.info(outputFolder);
        ITextRenderer renderer = new ITextRenderer();
        SharedContext sharedContext = renderer.getSharedContext();
        sharedContext.setPrint(true);
        sharedContext.setInteractive(false);
        sharedContext.setReplacedElementFactory(b64ImgReplacedElementFactory);
        sharedContext.getTextRenderer().setSmoothingThreshold(0);

        renderer.getFontResolver()
                .addFont(
                        new ClassPathResource("/templates/NanumBarunGothic.ttf")
                                .getURL()
                                .toString(),
                        BaseFont.IDENTITY_H,
                        BaseFont.EMBEDDED);
        renderer.setDocumentFromString(dynamicHtml);
        renderer.layout();

        renderer.createPDF(outputStream);

        outputStream.close();
        return outputStream;
    }
}