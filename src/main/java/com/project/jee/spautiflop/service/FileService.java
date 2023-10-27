package com.project.jee.spautiflop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FileService {

  private final String REFACTOR_PATH = "../../../static/";
  private final String PATH_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/";
  private final static String DEFAULT_IMAGE = "images/default.png";
  private final static String DEFAULT_PROFILE = "profiles/default.png";
  private final static String DEFAULT_ALBUM = "album/default.png";

  public String DEFAULT_IMAGE() {
    return REFACTOR_PATH + DEFAULT_IMAGE;
  }
  public String DEFAULT_PROFILE() {return REFACTOR_PATH + DEFAULT_PROFILE;}
  public String DEFAULT_ALBUM() {return REFACTOR_PATH + DEFAULT_ALBUM;}
  public String uploadImage(MultipartFile image) throws IOException {
    /* If no photo is provided, set the default one */
    if (image == null || image.isEmpty()) {
      return REFACTOR_PATH + "images/" + DEFAULT_IMAGE;
    }

    /* If a photo is provided, check if it is an image and save it */
    else if (image.getContentType() == null || !image.getContentType().startsWith("image/") || !ImageIO.read(image.getInputStream()).getClass().getSimpleName().equals("BufferedImage"))
    {
      System.out.println(image.getInputStream().getClass().getSimpleName());
      System.out.println(image.getContentType());
      throw new IOException("File is not an image");
    }

    else {
      String filePath = PATH_DIRECTORY + "images/" + String.valueOf(System.currentTimeMillis()) + image.getOriginalFilename();

      if (filePath.length() > 255)
        throw new IOException("File name too long");

      try {
        image.transferTo(new File(filePath));
        return filePath;
      } catch (IOException e) {
        throw new IOException("Error while saving photo  : " + e.getMessage());
      }
    }
  }

  public Image retreiveImage(String absolutePath) throws IllegalArgumentException, IOException {
    FileInputStream input = new FileInputStream(fileItem);
    MultipartFile multipartFile = new MockMultipartFile("fileItem",
            fileItem.getName(), "image/png", IOUtils.toByteArray(input));
    return (MultipartFile) ImageIO.read(new File(absolutePath));
    /*
    String[] split = absolutePath.split("/");
    return REFACTOR_PATH +  "images/" + split[split.length-1];*/
  }

  public String uploadMusic(MultipartFile music) throws IllegalArgumentException, IOException {
      /* If no music is provided, set the default one */
    if (music == null || music.isEmpty()) {
      throw new IllegalArgumentException("No music provided");
    }

    /* If a music is provided, check if it is a music and save it */
    else if (music.getContentType() == null || !music.getContentType().startsWith("audio/"))
      throw new IOException("File is not an audio, it's type : " + music.getContentType());

    else {
      String filePath = PATH_DIRECTORY + "musics/" + String.valueOf(System.currentTimeMillis()) + music.getOriginalFilename();

      if (filePath.length() > 255)
        throw new IOException("File name too long");

      try {
        music.transferTo(new File(filePath));
        return filePath;
      } catch (IOException e) {
        throw new IOException("Error while saving music  : " + e.getMessage());
      }
    } }
}
