# Interactive Map of Uzbekistan

This project is an interactive JavaFX-based map of Uzbekistan. Users can click on any region of the map to see information about the region, including its name, size, and population.

## Features

- **Clickable Map**: Click on a region to view its details.
- **Dynamic Region Identification**: Regions are identified by unique colors mapped in a `HashMap`.
- **Details Displayed**: Shows the name, size, and population of the selected region.

## How It Works

1. The map of Uzbekistan is color-coded, with each region assigned a distinct color.
2. When a region is clicked:
   - The pixel color at the clicked point is checked.
   - The corresponding region information (name, size, and population) is retrieved from a `HashMap` and displayed.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Ensure JDK 8 or higher is installed. [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- **JavaFX**: Required to run the project. Download and set up JavaFX libraries.

### Running the Application

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd uzbekistan_map
