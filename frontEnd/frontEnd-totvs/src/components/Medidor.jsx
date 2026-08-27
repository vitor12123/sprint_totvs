import React, { useState } from 'react';

function Medidor() {
  const [angle, setAngle] = useState(43);

  return (
    <div className="">

        <h2 className="text-3xl font-semibold mb-4 ml-[-6%] mt-[-4%]">
            Sentiment Analysis
        </h2>

        <div className="h-32 flex items-center justify-center">

            <div className="relative flex flex-col items-center justify-center">

                {/* Container do medidor */}
                <div className="relative w-[280px] h-[140px] bg-gradient-to-r from-red-400 via-yellow-400 to-green-400 bg-gray-200 rounded-t-[150px] overflow-hidden shadow-inner">

                    {/* PONTEIRO PRINCIPAL */}
                    <div
                    className="absolute bottom-0 left-1/2 w-1 h-[120px] bg-gray-800 rounded-t z-10 transition-transform duration-300 ease-in-out"
                    style={{
                        transform: `translateX(-50%) rotate(${angle}deg)`,
                        transformOrigin: 'bottom center',
                    }}
                    >
                    {/* Círculo central (eixo) */}
                    <div className="absolute -bottom-[6px] left-1/2 -translate-x-1/2 w-4 h-4 bg-gray-900 rounded-full border-2 border-white shadow-md" />
                    </div>
                </div>

            </div>

        </div>

        <p className="text-lg text-gray-400 mt-15 ml-[-6%]">
            Overall Sentiment: High Satisfaction ({Math.floor(((angle + 90) * 56) / 100 )} %)
            -
            Source: Meeting Transcripts & Emails
        </p>
    </div>
  );
}

export default Medidor;