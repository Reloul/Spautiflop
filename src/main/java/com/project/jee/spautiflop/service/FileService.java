package com.project.jee.spautiflop.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.*;
import java.net.MalformedURLException;
import java.net.UnknownServiceException;
import java.nio.file.Paths;

@Service
public class FileService {

  private final String PATH_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/";
  private final static String DEFAULT_IMAGE = "images_default.png";
  private final static String DEFAULT_PROFILE = "profiles_default.png";
  private final static String DEFAULT_ALBUM = "album_default.png";

  public String DEFAULT_IMAGE() {
    return PATH_DIRECTORY + DEFAULT_IMAGE;
  }
  public String DEFAULT_PROFILE() {return PATH_DIRECTORY + DEFAULT_PROFILE;}
  public String DEFAULT_ALBUM() {return PATH_DIRECTORY + DEFAULT_ALBUM;}

  public String retrieveAbsolutePathImage(String filename) {
    return PATH_DIRECTORY + "images/" + filename;
  }

  public String retrieveAbsolutePathMusic(String filename) {
    return PATH_DIRECTORY + "musics/" + filename;
  }
  public String uploadImage(MultipartFile image) throws IOException {
    /* If no photo is provided, set the default one */
    if (image == null || image.isEmpty()) {
      return DEFAULT_IMAGE;
    }

    /* If a photo is provided, check if it is an image and save it */
    else if (image.getContentType() == null || !image.getContentType().startsWith("image/") || !ImageIO.read(image.getInputStream()).getClass().getSimpleName().equals("BufferedImage"))
    {
      System.out.println(image.getInputStream().getClass().getSimpleName());
      System.out.println(image.getContentType());
      throw new IOException("File is not an image");
    }

    else {
      String filename = String.valueOf(System.currentTimeMillis()) + image.getOriginalFilename();
      String filePath = PATH_DIRECTORY + "images/" + filename;

      if (filePath.length() > 255)
        throw new IOException("File name too long");

      try {
        image.transferTo(new File(filePath));
        return filename;
      } catch (IOException e) {
        throw new IOException("Error while saving photo  : " + e.getMessage());
      }
    }
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
      String filename = String.valueOf(System.currentTimeMillis()) + music.getOriginalFilename();
      String filePath = PATH_DIRECTORY + "musics/" + filename;

      if (filePath.length() > 255)
        throw new IOException("File name too long");

      try {
        music.transferTo(new File(filePath));
        return filename;
      } catch (IOException e) {
        throw new IOException("Error while saving music  : " + e.getMessage());
      }
    }
  }

  public Resource retreiveFile(String absolutePath) throws  FileNotFoundException {
    try {
      Resource resource = new UrlResource(Paths.get(absolutePath).normalize().toUri());
      if(resource.exists())
        return resource;
      else
        throw new FileNotFoundException("file not found " + absolutePath);
    } catch (MalformedURLException ex) {
      throw new FileNotFoundException("File not found " + absolutePath + " catch MalformedURLException");
    }
  }
}
