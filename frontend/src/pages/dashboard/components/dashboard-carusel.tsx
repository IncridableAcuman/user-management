import { Card, CardContent, CardHeader, CardTitle } from "@/shared/ui/card";
import {
  Carousel,
  CarouselContent,
  CarouselItem,
  CarouselNext,
  CarouselPrevious,
} from "@/shared/ui/carousel";
import { useMemo } from "react";
import Autoplay from "embla-carousel-autoplay";
import { UseTheme } from "@/app/providers/ThemeProvider";

const DashboardCarusel = () => {
  const { theme } = UseTheme();
  const autoplay = useMemo(
    () =>
      Autoplay({
        delay: 2000,
        stopOnInteraction: true,
      }),
    [],
  );
  return (
    <div className="">
      <Card
        className={`${theme === "dark" ? "border border-fuchsia-950 bg-gray-950 hover:border-gray-900  transition duration-300" : ""}`}
      >
        <CardHeader className="flex items-center gap-3">
          <CardTitle className="text-lg md:text-xl font-semibold">
            Newspapers
          </CardTitle>
        </CardHeader>
        <CardContent>
          <Carousel
            plugins={[autoplay]}
            onMouseEnter={() => autoplay.stop()}
            onMouseLeave={() => autoplay.stop()}
          >
            <CarouselContent>
              {Array.from({ length: 5 }).map((_, index) => (
                <CarouselItem key={index}>
                  <div className="p-1">
                    <Card>
                      <CardContent className="flex items-center justify-center p-6">
                        <img src={"profile.png"} alt="profile" className="w-full  object-cover" />
                      </CardContent>
                    </Card>
                  </div>
                </CarouselItem>
              ))}
            </CarouselContent>
            <CarouselPrevious />
            <CarouselNext />
          </Carousel>
        </CardContent>
      </Card>
    </div>
  );
};

export default DashboardCarusel;
