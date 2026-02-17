# KMZ → Excel (MAPS.me pins)

Simple client-side web app to extract pinned locations from a MAPS.me `.kmz` file and download an `.xlsx` spreadsheet.

Usage
1. Open `index.html` in a modern browser (Chrome, Edge, Firefox) or serve the folder with a local HTTP server.
2. Either drag & drop a `.kmz` onto the page, or click `Choose KMZ file` and select your `.kmz` exported from MAPS.me.
3. A preview (up to 20 placemarks) will appear. Click `Export to Excel` to download an `.xlsx` workbook containing all extracted placemarks.

Notes
- This is a fully client-side solution — no server required for normal use. If you open the file directly and your browser disallows local JS+file access, serve the folder as described below.
- Serve locally (if needed):

  ```bash
  # Python 3
  python -m http.server 8000
  # or using the Windows py launcher
  py -3 -m http.server 8000
  ```

  Then open `http://localhost:8000` in a browser.

Troubleshooting
- No `.kml` found: open the `.kmz` with a zip tool and inspect its contents. A valid KMZ normally contains at least one `.kml` file.
- Missing placemarks: Some exporters wrap placemarks in custom folders or use non-standard tags. Open the `.kml` in a text editor and look for `<Placemark>` elements.
- Coordinates format: The exported `Coordinates` column is formatted as `latitude, longitude` (with a space after the comma).
- If the browser blocks the Excel download, try a different browser (Chrome/Edge/Firefox recommended).

Next steps
- Add drag-and-drop support, column selection, and CSV export option.
