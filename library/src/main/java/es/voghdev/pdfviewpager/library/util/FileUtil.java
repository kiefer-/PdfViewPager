/*
 * Copyright (C) 2016 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.voghdev.pdfviewpager.library.util;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import es.voghdev.pdfviewpager.library.BuildConfig;

public class FileUtil {
    public static boolean copyAsset(Context ctx, String assetName, String destinationPath){
        try{
            InputStream in = ctx.getAssets().open(assetName);
            OutputStream out = new FileOutputStream(new File(destinationPath));

            byte[] buffer = new byte[1024];
            int read;
            while((read = in.read(buffer)) != -1){
                out.write(buffer, 0, read);
            }
            in.close();
            out.close();

        }catch(IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static String extractFileNameFromURL(String url){
        return url.substring(url.lastIndexOf('/') + 1);
    }
}