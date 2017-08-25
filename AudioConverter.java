package QnA;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioConverter {
	public static void main(String args[]) {
		AudioConverter con = new AudioConverter();
		String path = "/home/local/NEXTEDUCATION/mayankagrawal/RICHA";
		final File folder = new File(path);

		con.listFilesForFolder(folder);

	}

	public void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else if (fileEntry.getName().contains("mp3")) {
				/*ConvertFileToWAV(fileEntry,
						"/home/local/NEXTEDUCATION/mayankagrawal/output_wav/" + fileEntry.getName() + ".wav");*/
				//getAudioDataBytes(IOUtils audioFormat)
			}
		}
	}

	public void ConvertFileToWAV(File inFile, String outputPath) {
		AudioFileFormat inFileFormat;
		File outFile;
		try {
			outFile = new File(outputPath);
		} catch (NullPointerException ex) {
			System.out.println("Error: one of the ConvertFileToAIFF" + " parameters is null!");
			return;
		}
		try {
			// query file type
			inFileFormat = AudioSystem.getAudioFileFormat(inFile);

			AudioInputStream inFileAIS = AudioSystem.getAudioInputStream(inFile);
			inFileAIS.reset(); // rewind
			if (AudioSystem.isFileTypeSupported(AudioFileFormat.Type.WAVE, inFileAIS)) {
				// inFileAIS can be converted to AIFF.
				// so write the AudioInputStream to the
				// output file.
				AudioSystem.write(inFileAIS, AudioFileFormat.Type.WAVE, outFile);
				System.out.println("Successfully made AIFF file, " + outFile.getPath() + ", from "
						+ inFileFormat.getType() + " file, " + inFile.getPath() + ".");
				inFileAIS.close();
				return; // All done now
			} else
				System.out.println("Warning: AIFF conversion of " + inFile.getPath()
						+ " is not currently supported by AudioSystem.");

		} catch (UnsupportedAudioFileException e) {
			System.out.println("Error: " + inFile.getPath() + " is not a supported audio file type!");
			return;
		} catch (IOException e) {
			System.out.println("Error: failure attempting to read " + inFile.getPath() + "!");
			return;
		}
	}

	public static byte[] getAudioDataBytes(byte[] sourceBytes, AudioFormat audioFormat)
			throws UnsupportedAudioFileException, IllegalArgumentException, Exception {
		if (sourceBytes == null || sourceBytes.length == 0 || audioFormat == null) {
			throw new IllegalArgumentException("Illegal Argument passed to this method");
		}

		try (final ByteArrayInputStream bais = new ByteArrayInputStream(sourceBytes);
				final AudioInputStream sourceAIS = AudioSystem.getAudioInputStream(bais)) {
			AudioFormat sourceFormat = sourceAIS.getFormat();
			AudioFormat convertFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, sourceFormat.getSampleRate(),
					16, sourceFormat.getChannels(), sourceFormat.getChannels() * 2, sourceFormat.getSampleRate(),
					false);
			try (final AudioInputStream convert1AIS = AudioSystem.getAudioInputStream(convertFormat, sourceAIS);
					final AudioInputStream convert2AIS = AudioSystem.getAudioInputStream(audioFormat, convert1AIS);
					final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
				byte[] buffer = new byte[8192];
				while (true) {
					int readCount = convert2AIS.read(buffer, 0, buffer.length);
					if (readCount == -1) {
						break;
					}
					baos.write(buffer, 0, readCount);
				}
				return baos.toByteArray();
			}
		}
	}
}
