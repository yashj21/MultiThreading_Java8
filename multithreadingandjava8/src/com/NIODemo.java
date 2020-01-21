package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class NIODemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//use channels of nio2 to improve fast 
		
		memoryMapped();
		
		
		
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("C");//give proper path here and below in memory mapped byte method
			FileChannel inputChannel = fis.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			ByteBuffer buffer1 = ByteBuffer.allocateDirect(1023);
			//for large file use memory mapped byte buffer rather than bytebuffer it loads chunks of file at a time into memory
			while(true)
			{
				int ch = inputChannel.read(buffer);
				if(ch == -1) break;
				buffer.clear();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void memoryMapped() {
		try (RandomAccessFile file = new RandomAccessFile("C", "r"))//we need to have random access file for memory mapped 
		{	
			FileChannel channel = file.getChannel();
			MappedByteBuffer buffer = channel.map(MapMode.READ_ONLY, 0, file.length());
			
			
		}
 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
