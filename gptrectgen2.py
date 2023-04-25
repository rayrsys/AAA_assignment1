import random
import csv
import os
import matplotlib.pyplot as plt

os.makedirs("png", exist_ok=True)

# Clear csv and png folders
for file_name in os.listdir("csv"):
    os.remove(os.path.join("csv", file_name))
for file_name in os.listdir("png"):
    os.remove(os.path.join("png", file_name))

def rect_overlap(r1, r2):
    # Check if two rectangles overlap
    x1, y1, x2, y2 = r1
    x3, y3, x4, y4 = r2
    return not (x2 < x3 or x1 > x4 or y2 < y3 or y1 > y4)


def generate_rectangles(num_rectangles):
    # Generate non-overlapping rectangles
    rectangles = []
    while len(rectangles) < num_rectangles:
        x1, x2 = sorted([random.randint(0, 10000), random.randint(0, 10000)])
        y1, y2 = sorted([random.randint(0, 10000), random.randint(0, 10000)])
        if x2 - x1 >= 5 and y2 - y1 >= 10:
            rect = [x1, y1, x2, y2]
            if all(not rect_overlap(rect, r) for r in rectangles):
                rectangles.append(rect)
    return rectangles


for num_rectangles in range(1, 1000):
    filename = f"rectangles_{num_rectangles}.csv"
    with open(os.path.join("csv", filename), mode="w", newline="") as f:
        writer = csv.writer(f)
        writer.writerow(["Num Rectangles", "Rectangle Number", "x1", "y1", "x2", "y2"])

        rectangles = generate_rectangles(num_rectangles)
        for i, rect in enumerate(rectangles):
            writer.writerow([num_rectangles, i+1] + rect)
        print(f"Generated rectangles saved to {filename}")

        x_min, y_min = min(rect[0] for rect in rectangles), min(rect[1] for rect in rectangles)
        x_max, y_max = max(rect[2] for rect in rectangles), max(rect[3] for rect in rectangles)
        fig, ax = plt.subplots()
        for rect in rectangles:
            x1, y1, x2, y2 = rect
            ax.add_patch(plt.Rectangle((x1, y1), x2 - x1, y2 - y1, fill=None, lw=2))
        plt.xlim([x_min - 1, x_max + 1])
        plt.ylim([y_min - 1, y_max + 1])
        plt.gca().set_aspect('equal', adjustable='box')
        plt.savefig(os.path.join("png", f"rectangles_{num_rectangles}.png"))
        print(f"Plot saved to rectangles_{num_rectangles}.png")
