/* NFCard is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 3 of the License, or
(at your option) any later version.

NFCard is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Wget.  If not, see <http://www.gnu.org/licenses/>.

Additional permission under GNU GPL version 3 section 7 */

package com.seedsoft.ykt.nfc;

import android.app.Application;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.seedsoft.ykt.activity.R;

public class ThisApplication extends Application  {
	private static ThisApplication instance;
//	//==============系统框架基类数据源==================
//		ArrayList<RootBean> rootBeans;
//
//		public ArrayList<RootBean> getRootBeans() {
//			return rootBeans;
//		}
//
//		public void setRootBeans(ArrayList<RootBean> rootBeans) {
//			this.rootBeans = rootBeans;
//		}	
//	@Override
//	public void uncaughtException(Thread thread, Throwable ex) {
//		System.exit(0);
//	}

	@Override
	public void onCreate() {
		super.onCreate();

//		Thread.setDefaultUncaughtExceptionHandler(this);

		instance = this;
	}

	public static String name() {
		return getStringResource(R.string.app_name);
	}

	public static String version() {
		try {
			return instance.getPackageManager().getPackageInfo(
					instance.getPackageName(), 0).versionName;
		} catch (Exception e) {
			return "1.0";
		}
	}

	public static void showMessage(int fmt, CharSequence... msgs) {
		String msg = String.format(getStringResource(fmt), msgs);
		Toast.makeText(instance, msg, Toast.LENGTH_LONG).show();
	}

	public static Typeface getFontResource(int pathId) {
		String path = getStringResource(pathId);
		return Typeface.createFromAsset(instance.getAssets(), path);
	}

	public static int getDimensionResourcePixelSize(int resId) {
		return instance.getResources().getDimensionPixelSize(resId);
	}

	public static int getColorResource(int resId) {
		return instance.getResources().getColor(resId);
	}

	public static String getStringResource(int resId) {
		return instance.getString(resId);
	}

	public static Drawable getDrawableResource(int resId) {
		return instance.getResources().getDrawable(resId);
	}

	public static DisplayMetrics getDisplayMetrics() {
		return instance.getResources().getDisplayMetrics();
	}
}
