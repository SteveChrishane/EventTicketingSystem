import React from "react";

interface TicketStatusProps {
  availableTickets: number;
  maxCapacity: number;
}

const TicketStatus: React.FC<TicketStatusProps> = ({
  availableTickets,
  maxCapacity,
}) => {
  return (
    <div>
      <h2>Ticket Pool Status</h2>
      <p>
        Tickets Available: {availableTickets} / {maxCapacity}
      </p>
    </div>
  );
};

export default TicketStatus;
